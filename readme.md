#### todo list

- [ ] 答辩ppt
- [ ] ER图
- [ ] 创建数据库、设计文档

#### work list
- 登录*XCY*
- 展示所有类别（header）*YS*
- 根据类别查询所有路线*CWY*
- 路线详情*LYZ*
- 收藏*HZW*
- 搜索(模糊查询)*XWR*


#### note
MAVEN：解决依赖问题


update:
```java
//1.定义sql
        String sql = "insert into tab_user(username,password,name,birthday,sex,telephone,email,status,code) values(?,?,?,?,?,?,?,?,?)";
        //2.执行sql

        template.update(sql,user.getUsername(),
                    user.getPassword(),
                user.getName(),
                user.getBirthday(),
                user.getSex(),
                user.getTelephone(),
                user.getEmail(),
                user.getStatus(),
                user.getCode()
                );
```
query:
```java
public User findByUsername(String username) {
        User user = null;
        try {
            //1.定义sql
            String sql = "select * from tab_user where username = ?";
            //2.执行sql
            user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username);
        } catch (Exception e) {
        }
        return user;
    }
```    
