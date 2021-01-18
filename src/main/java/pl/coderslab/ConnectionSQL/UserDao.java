package pl.coderslab.ConnectionSQL;

import java.sql.*;
import java.util.Arrays;

public class UserDao {
    private static final String FIND_ALL_USERS = "SELECT * FROM users";
    private static final String READ_USER = "SELECT * FROM users WHERE user_id = ?";
    private static final String CREATE_USER = "INSERT INTO users(username, email, password) VALUES (?, ?, ?)";
    private static final String UPDATE_USER = "UPDATE users SET username = ?, email = ?, password = ? where user_id = ?";
    private static final String DELETE_USER = "DELETE FROM users WHERE user_id = ?";

    private User[] addToArray(User u, User[] users) {
        User[] tmpUsers = Arrays.copyOf(users, users.length + 1);
        tmpUsers[users.length] = u;
        return tmpUsers;
    }

    public User createUser(User user) {
        System.out.println(user.getUsername());
        System.out.println(user.getEmail());
        System.out.println(user.getPassword());
        try (Connection connect = DBUtill.getConnection()) {
            PreparedStatement preparedStatement = connect.prepareStatement(CREATE_USER, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                user.setUserId(resultSet.getLong(1));
                System.out.println("Is created");
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

    public void updateUser(User user) {
        try (Connection connect = DBUtill.getConnection()) {
            PreparedStatement preparedStatement = connect.prepareStatement(UPDATE_USER);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setLong(4, user.getUserId());
            preparedStatement.executeUpdate();
            System.out.println("Sucsses");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeUser(long userId) {
        try (Connection connect = DBUtill.getConnection()) {
            PreparedStatement preparedStatement = connect.prepareStatement(DELETE_USER);
            preparedStatement.setLong(1, userId);
            preparedStatement.executeUpdate();
            System.out.println("Is delete");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User readUser(long userId) {
        User user = null;
        try (Connection connect = DBUtill.getConnection()) {
            PreparedStatement preparedStatement = connect.prepareStatement(READ_USER);
            preparedStatement.setLong(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                user = new User(resultSet.getLong("user_id"), resultSet.getString("username"), resultSet.getString("email"), resultSet.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public User[] findAllUsers() {
        try (Connection connect = DBUtill.getConnection()) {
            User[] users = new User[0];
            PreparedStatement preparedStatement = connect.prepareStatement(FIND_ALL_USERS);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                user.setUserId(resultSet.getLong("user_id"));
                user.setUsername(resultSet.getString("username"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                users = addToArray(user, users);
            }
            return users;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}