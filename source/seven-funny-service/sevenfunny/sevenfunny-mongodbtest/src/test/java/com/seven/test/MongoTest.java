package com.seven.test;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：SevenRyuu
 * date   ：2019/9/6 1:47 PM
 * email  ：sevenryuu77@gmail.com
 */
public class MongoTest {
    public static void main(String[] args) {
        //连接mongo服务器
        MongoClient client = new MongoClient("192.168.0.200");
        //得到要操作的数据库
        MongoDatabase roastdb = client.getDatabase("roastdb");
        //得到要操作的集合
        MongoCollection<Document> roast = roastdb.getCollection("roast");
        //封装查询条件(只查询访问量为7的)
        //BasicDBObject bson = new BasicDBObject("visits",7);
        //封装查询条件(只查询访问量大于6的)
        //BasicDBObject bson = new BasicDBObject("visits",new BasicDBObject("$gt", 6));
        //得到集合中所有的文档
        //FindIterable<Document> documents = roast.find(bson);
        //遍历数据
        /*for (Document document : documents){
            System.out.println("内容: "+document.getString("content"));
            System.out.println("用户昵称: "+document.getString("nickname"));
            System.out.println("访问量: "+document.getDouble("visits"));
        }*/

        //添加记录
        Map<String, Object> map = new HashMap<>();
        map.put("nickname", "java创建");
        map.put("content", "java内容");
        map.put("visits", 90);
        Document document = new Document(map);
        roast.insertOne(document);

        client.close();
    }
}
