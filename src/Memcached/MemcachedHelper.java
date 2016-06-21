package Memcached;

import java.util.Date;
import java.util.Map;
 
import com.danga.MemCached.MemCachedClient;
import com.danga.MemCached.SockIOPool;
 
 
public class MemcachedHelper {
 
    private static MemCachedClient mcc = new MemCachedClient();
     
    static {
        //创建Socket连接池实例
        SockIOPool spool = SockIOPool.getInstance();        
        String[] servers = {"127.0.0.1:11211"};
        Integer[] weights = {3};        
        //设置服务器信息
        spool.setServers(servers);
        spool.setWeights(weights);      
        spool.setFailover(true);        
        //设置初始连接数、最小和最大连接数以及最大处理时间
        spool.setInitConn(5);
        spool.setMinConn(5);
        spool.setMaxConn(250);
        spool.setMaxIdle(1000 * 60 * 60 * 6);          
        //设置主线程睡眠时间
        spool.setMaintSleep(30);           
        //设置TCP参数、连接超时等
        spool.setNagle(false);
        spool.setSocketTO(3000);
        spool.setSocketConnectTO(0);
        spool.setAliveCheck(true);         
        //初始化连接池
        spool.initialize(); 
    }   
     
    protected MemcachedHelper(){
    }
     
    protected static MemcachedHelper instance = new MemcachedHelper();
     
    /**
     * 为受保护的对象提供一个公共的访问方法
     */
    public static MemcachedHelper getInstance () {
       return instance;
    }
     
    /**
     * 插入一条记录到缓存服务器中
     * @param key
     * @param value
     * @return
     */
    public boolean add(String key,Object value) {
       return mcc.add(key, value);
    }
    /**
     * 插入一条记录到缓存服务器，并设置过期时间，单位为秒
     * @param key
     * @param value
     * @param expiry
     * @return
     */
    public boolean add (String key,Object value,Date expiry) {
       return mcc.add(key, value,expiry);
    }
    /**
     * 根据KEY替换缓存服务器中的数据
     * @param key
     * @param value
     * @return
     */
    public boolean replace (String key,Object value) {
       return mcc.replace(key, value);
    }
     
    public boolean replace (String key,Object value,Date expiry) {   
       return mcc.replace(key, value, expiry);
    }
    /**
     * 当KEY不存在时将数据添加到缓存服务器中
     * 当KEY存在时则替换原来的数据
     * @param key
     * @param value
     * @return
     */
    public boolean set(String key,Object value){
        return mcc.set(key, value);
    }
     
    public boolean set(String key,Object value,Date expiry){
        return mcc.set(key, value,expiry);
    }    
   
    /**
     * 根据KEY删除缓存服务器中的数据
     * @param key
     * @return
     */
    public boolean delete(String key){
        return mcc.delete(key);
    }   
    /**
     * 根据指定的KEY获取数据
     */
    public Object get(String key) {
       return mcc.get(key);
    }
     
    /**
     * 批量获取多个KEY的数据
     * @param keys
     * @return
     */
    public Map<String,Object> getMulti(String[] keys){
        return mcc.getMulti(keys);
    }
     
    /**
     * 判断指定的KEY是否已经存在
     * @param key
     * @return
     */
    public boolean keyExists(String key){
        return mcc.keyExists(key);
    }
}