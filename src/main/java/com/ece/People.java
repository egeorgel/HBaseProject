package main.java.com.ece;
import java.io.IOException;
import java.util.List;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.util.Bytes;


/**
 * Created by Edgar on 29/10/2016.
 */
public class People {

    public People() throws IOException {
        Configuration conf = HBaseConfiguration.create();
        HBaseAdmin admin = new HBaseAdmin(conf);
        if (!admin.tableExists("people")) {
            HTableDescriptor tableDescriptor = new HTableDescriptor(TableName.valueOf("people"));
            tableDescriptor.addFamily(new HColumnDescriptor("info"));
            tableDescriptor.addFamily(new HColumnDescriptor("friends"));
            admin.createTable(tableDescriptor);
        }
    }

    public void add(String firstName, String lastName, String age, String email, String sex, String bff, List<String> friends) throws IOException {
        // define people
        Configuration conf = HBaseConfiguration.create();
        HTable table = new HTable(conf, "people");
        Put put = new Put(Bytes.toBytes(firstName));
        put.add(Bytes.toBytes("info"), Bytes.toBytes("lastName"), Bytes.toBytes(lastName));
        put.add(Bytes.toBytes("info"), Bytes.toBytes("age"), Bytes.toBytes(age));
        put.add(Bytes.toBytes("info"), Bytes.toBytes("email"), Bytes.toBytes(email));
        put.add(Bytes.toBytes("info"), Bytes.toBytes("sex"), Bytes.toBytes(sex));

        put.add(Bytes.toBytes("friends"), Bytes.toBytes("bff"), Bytes.toBytes(bff));
        //friends.forEach(name -> put.add(Bytes.toBytes("friends"), Bytes.toBytes("others"), Bytes.toBytes(name)));

        table.put(put);
        System.out.println("data inserted");
        table.close();
    }
}
