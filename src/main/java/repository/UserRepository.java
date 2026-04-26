//usertableからselect文を実行するためのクラス

package repository;

//modelのインポート
import model.User;

//DB接続のクラスをimport
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;

public class UserRepository {

    //ユーザーテーブルから全てのユーザーを取得するメソッド
    public void selectUsers() {
        String sql = "SELECT * FROM users";

        try (
            Connection conn = DBConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                System.out.println("ID: " + id + ", Name: " + name);
            }
        }
            //SQLExceptionが発生した場合はRuntimeExceptionをスローする
            catch (SQLException e) {
                throw new RuntimeException("ユーザーの取得に失敗しました", e);
        }
    }

    //ユーザーテーブルに新しいユーザーを追加するメソッド
    public void insertUser(User user) {
        String sql = "INSERT INTO users (id, name) VALUES (?, ?)";
        try(
            Connection con = DBConnection.getConnection();
            PreparedStatement pstm = con.prepareStatement(sql)
        ) {
            pstm.setInt(1, user.getId());
            pstm.setString(2, user.getName());
            pstm.executeUpdate();
        }
        //SQLExceptionが発生した場合はRuntimeExceptionをスローする
        catch (SQLException e) {
            throw new RuntimeException("ユーザーの追加に失敗しました", e);
        }
    }

    //ユーザーテーブルから特定の更新を行うメソッド
    public void updateUser(User user){
        String sql = "UPDATE users SET name = ? WHERE id = ?";
        try(
            Connection con = DBConnection.getConnection();
            PreparedStatement pstm = con.prepareStatement(sql)
        ) {
            pstm.setString(1, user.getName());
            pstm.setInt(2, user.getId());
            pstm.executeUpdate();
        }
        //SQLExceptionが発生した場合はRuntimeExceptionをスローする
        catch (SQLException e) {
            throw new RuntimeException("ユーザーの更新ができませんでした。",e);
        }
    }

    //ユーザーーテーブルから特定のidを削除を行うメソッド
    public void deleteUser(int id){
        String sql = "DELETE FROM users WHERE id = ?";
        try(
            Connection con = DBConnection.getConnection();
            PreparedStatement pstm = con.prepareStatement(sql)
        ) {
            pstm.setInt(1, id);
            pstm.executeUpdate();
        }
        //SQLExceptionが発生した場合はRuntimeExceptionをスローする
        catch (SQLException e) {
            throw new RuntimeException("ユーザーの削除ができませんでした。", e);
        }
    }
}