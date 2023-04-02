package bank.dao;

import bank.pojo.Account;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface AccountMapper {
    /**
     * 新增账户
     * @param account
     * @return
     */
    @Insert("insert into bank values(null,#{cusName},#{balance})")
    int insert(Account account);

    /**
     * 根据id删除账户
     * @param id
     * @return
     */
    @Delete("delete from bank where id = #{id}")
    int deleteById(@Param("id") Long id);

    /**
     * 根据账户更新
     * @param account
     * @return
     */
    @Update("update bank set balance = #{balance} where cus_name = #{cusName}")
    int updateByName(Account account);

    /**
     * 根据name查询账户
     * @param name
     * @return
     */
    @Select("select id,cus_name as cusName,balance from bank where cus_name = #{name}")
    Account selectByName(@Param("name") String name);

    /**
     * 查询所有账户
     * @return
     */
    @Select("select id,cus_nmae as cusName,balance from bank ")
    List<Account> selectAll();
}
