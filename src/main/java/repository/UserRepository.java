//usertableからselect文を実行するためのクラス

package repository;
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
    public void insertUser(String name,int id){
        String sql = "INSERT INTO users (id, name) VALUES (?, ?)";
        try(
            Connection con = DBConnection.getConnection();
            PreparedStatement pstm = con.prepareStatement(sql)
        ) {
            pstm.setInt(1, id);
            pstm.setString(2, name);
            pstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //ユーザーテーブルから特定の更新を行うメソッド
    public void updateUser(String namem,int id){
        String sql = "UPDATE users SET name = ? WHERE id = ?";
        try(
            Connection con = DBConnection.getConnection();
            PreparedStatement pstm = con.prepareStatement(sql)
        ) {
            pstm.setString(1, namem);
            pstm.setInt(2, id);
            pstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}