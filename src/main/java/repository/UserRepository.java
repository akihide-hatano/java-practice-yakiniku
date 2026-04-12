//usertableからselect文を実行するためのクラス

package repository;

//modelのインポート
import model.User;

//DB接続のクラスをimport
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
        } catch (Exception e) {
            e.printStackTrace();
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
        } catch (Exception e) {
            e.printStackTrace();
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //ユーザーーテーブルから特定のidを削除を行うメソッド
    public void deleteUser(User user){
        String sql = "DELETE FROM users WHERE id = ?";
        try(
            Connection con = DBConnection.getConnection();
            PreparedStatement pstm = con.prepareStatement(sql)
        ) {
            pstm.setInt(1, user.getId());
            pstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
    }
}
}