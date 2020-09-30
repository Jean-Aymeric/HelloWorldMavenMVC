package model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import shared.model.entity.HelloWorld;

class DAOHelloWorld extends DAOEntity<HelloWorld> {

    public DAOHelloWorld(final Connection connection) throws SQLException {
        super(connection);
    }

    @Override
    public boolean create(final HelloWorld entity) {
        // Not implemented
        return false;
    }

    @Override
    public boolean delete(final HelloWorld entity) {
        return false;
    }

    @Override
    public boolean update(final HelloWorld entity) {
        return false;
    }

    @Override
    public HelloWorld find(final int id) {
        HelloWorld helloWorld = new HelloWorld();

        try {
            final String sql = "{call helloworldById(?)}";
            final CallableStatement call = this.getConnection().prepareCall(sql);
            call.setInt(1, id);
            call.execute();
            final ResultSet resultSet = call.getResultSet();
            if (resultSet.first()) {
                helloWorld = new HelloWorld(id, resultSet.getString("code"), resultSet.getString("message"));
            }
            return helloWorld;
        } catch (final SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public HelloWorld find(final String code) {
        HelloWorld helloWorld = new HelloWorld();

        try {
            final String sql = "{call helloworldByCode(?)}";
            final CallableStatement call = this.getConnection().prepareCall(sql);
            call.setString(1, code);
            call.execute();
            final ResultSet resultSet = call.getResultSet();
            if (resultSet.first()) {
                helloWorld = new HelloWorld(resultSet.getInt("id"), code, resultSet.getString("message"));
            }
            return helloWorld;
        } catch (final SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
