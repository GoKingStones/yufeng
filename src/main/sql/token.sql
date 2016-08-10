DROP TABLE if EXISTS token_table;
CREATE TABLE token_table(

  register_account_id INT PRIMARY KEY NOT NULL COMMENT '',
  token VARCHAR(100) NOT NULL COMMENT '',
  createTime TIMESTAMP DEFAULT current_timestamp

)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='token表';