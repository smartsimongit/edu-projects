package org.smart.simon.edu.problems.interviews.review;


import javax.sql.DataSource;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.sql.*;
import java.util.Objects;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cat4Review {
    private static final Logger LOGGER = Logger.getLogger(Cat4.class.getName());
    private static final String DEFAULT_CAT_NAME = "Max";
    private static final String WEIGHT_QUERY = "SELECT weight FROM Cat WHERE name = ?";

    private final ConcurrentMap<byte[], BigDecimal> cache = new ConcurrentHashMap<>();
    private final AtomicInteger jumpsCount = new AtomicInteger(0);
    private volatile Cat4Profile cat4Profile;
    private final DataSource dataSource;
    private final ExecutorService jumpExecutor;

    public Cat4Review(DataSource dataSource) {
        this.dataSource = Objects.requireNonNull(dataSource, "DataSource cannot be null");
        this.jumpExecutor = Executors.newCachedThreadPool();
    }

    public void doRandomJumps(int maxJumps) {
        if (maxJumps <= 0) {
            throw new IllegalArgumentException("Max jumps must be positive");
        }

        int jumpsToDo = ThreadLocalRandom.current().nextInt(maxJumps) + 1;
        for (int i = 0; i < jumpsToDo; i++) {
            jumpExecutor.execute(this::doJump);
        }
    }

    public void setCat4Profile(Cat4Profile cat4Profile) {
        this.cat4Profile = Objects.requireNonNull(cat4Profile, "Cat4Profile cannot be null");
    }

    public String getCat4Name() {
        Cat4Profile profile = this.cat4Profile;
        return profile != null ? profile.getCatName() : DEFAULT_CAT_NAME;
    }

    public void doJump() {
        jumpsCount.incrementAndGet();
        LOGGER.fine("Jump!");
    }

    public void doMeow() {
        LOGGER.fine("Meow!");
    }

    public BigDecimal doQuery(byte[] parameters) throws SQLException {
        Objects.requireNonNull(parameters, "Parameters cannot be null");

        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(WEIGHT_QUERY)) {

            stmt.setString(1, new String(parameters, StandardCharsets.UTF_8));
            try (ResultSet resultSet = stmt.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getBigDecimal("weight");
                }
                throw new SQLException("No results found");
            }
        }
    }

    public BigDecimal doQueryCached(byte[] parameters) throws SQLException {
        return cache.computeIfAbsent(parameters, key -> {
            try {
                return doQuery(key);
            } catch (SQLException e) {
                LOGGER.log(Level.SEVERE, "Query failed", e);
                throw new CompletionException(e);
            }
        });
    }

    public int getAndResetJumpsCount() {
        return jumpsCount.getAndSet(0);
    }

    public void shutdown() {
        jumpExecutor.shutdown();
        try {
            if (!jumpExecutor.awaitTermination(5, TimeUnit.SECONDS)) {
                jumpExecutor.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            jumpExecutor.shutdownNow();
        }
    }


    private class Cat4Profile {
        private String catName;

        public String getCatName() {
            return catName;
        }

        public void setCatName(String catName) {
            this.catName = catName;
        }
    }
}
