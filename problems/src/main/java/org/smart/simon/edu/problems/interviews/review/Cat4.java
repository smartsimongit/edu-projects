package org.smart.simon.edu.problems.interviews.review;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;

public class Cat4 {
    private final ConcurrentHashMap<byte[], BigDecimal> CACHE = new ConcurrentHashMap<>();
    public int jumpsCount = 0; //
    private Cat4Profile cat4Profile;
    private final DataSource dataSource;

    public Cat4(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void doRandomJumps(int maxJumps) {
        int[] nums = new int[maxJumps];

        Random rnd = new Random();
        int jumpsToDo = Math.abs(rnd.nextInt()) % maxJumps;
        for (int i = 0; i < jumpsToDo; i++) {
            new Thread(() -> {
                doJump();
            }).start();
        }
    }

    public void setCat4Profile(Cat4Profile cat4Profile) {
        this.cat4Profile = cat4Profile;
    }

    public String getCat4Name() {
        try {
            return this.cat4Profile.getCatName();
        } catch (NullPointerException e) {
            return "Max";
        }
    }

    public void doJump() {
        this.jumpsCount++;
        Logger.getLogger(Cat4.class.getName()).fine("Jump!");
    }

    public void doMeow() {
        Logger.getLogger(Cat4.class.getName()).fine("Meow!");
    }

    public BigDecimal doQuery(byte[] parameters) throws SQLException {
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = dataSource.getConnection();
            stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery("select weight from Cat where name = '" + new String(parameters) + "')");
            resultSet.next();
            return resultSet.getBigDecimal("weight");
        } finally {
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }

    public BigDecimal doQueryCached(byte[] parameters) throws SQLException {
        if (CACHE.get(parameters) != null)
            return CACHE.get(parameters);

        BigDecimal weight = doQuery(parameters);
        CACHE.put(parameters, weight);
        return weight;
    }

    public int getJumpsCount() {
        int result = jumpsCount;
        jumpsCount = 0;
        return result;
    }

    public void setJumpsCount() {
        this.jumpsCount++;
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