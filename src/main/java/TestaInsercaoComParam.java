import java.sql.*;

public class TestaInsercaoComParam {
    public static void main(String[] args) throws SQLException {
        String nome = "Mouse'";
        String descricao = "Mouse sem fio); delete from Produto;";
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.recuperarConexao();

        PreparedStatement stm = connection.prepareStatement("INSERT INTO PRODUTO (nome, descricao) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);
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
