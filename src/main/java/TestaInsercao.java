import java.sql.*;

public class TestaInsercao {
    public static void main(String[] args) throws SQLException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.recuperarConexao();

        String nome = "";
        String descricao ="";

        PreparedStatement stm = connection.prepareStatement
                ("INSERT INTO PRODUTO (nome, descricao) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);
        stm.setString(1, nome);
        stm.setString(2, descricao);

        stm.execute();

        ResultSet rst = stm.getGeneratedKeys();
        while (rst.next()){
            Integer id = rst.getInt(1);
            System.out.println("O id criado foi: " + id);
        }

    }
}
