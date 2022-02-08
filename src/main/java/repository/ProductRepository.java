package repository;

import entity.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements interfaceRepository <Product> {
    private Connection connection;

    public ProductRepository(Connection connection) {
        this.connection = connection;
    }

    @Override
    public int add(Product product) throws SQLException {
        String insert="insert into product (adminId,categoryId,name) values(?,?,?)";
        PreparedStatement preparedStatement=connection.prepareStatement(insert);
        preparedStatement.setInt(1,product.getAdminId());
        preparedStatement.setInt(2,product.getCategoryId());
        preparedStatement.setString(3,product.getName());
        return preparedStatement.executeUpdate();
    }

    @Override
    public List<Product> findAll() throws SQLException {
        String select="select * from product";
        PreparedStatement preparedStatement=connection.prepareStatement(select);
        ResultSet resultSet=preparedStatement.executeQuery();
        List<Product> products=new ArrayList<>();
        while(resultSet.next()){
            Product product=new Product(resultSet.getInt("id"),resultSet.getInt("adminId"),resultSet.getInt("categoryId"),resultSet.getString("name"));
            products.add(product);
        }
        return products;
    }

    @Override
    public int update(Product product) throws SQLException {
        String update="update product set adminId=?, categoryId=?, name=? where id=?";
        PreparedStatement preparedStatement=connection.prepareStatement(update);
        preparedStatement.setInt(1,product.getAdminId());
        preparedStatement.setInt(2,product.getCategoryId());
        preparedStatement.setString(3,product.getName());
        preparedStatement.setInt(4,product.getId());
        return preparedStatement.executeUpdate();
    }

    @Override
    public int delete(int id) throws SQLException {
        String delete="delete from product where id=?";
        PreparedStatement preparedStatement=connection.prepareStatement(delete);
        preparedStatement.setInt(1,id);

        return preparedStatement.executeUpdate();
    }
}
