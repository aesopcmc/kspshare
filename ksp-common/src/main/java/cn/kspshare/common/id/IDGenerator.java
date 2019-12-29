package cn.kspshare.common.id;
/**
 * 数据库主键生成
 * Create by CMC(chao_c_c@163.com) 2018/11/16 0:09
 */
public class IDGenerator {
    private static final SnowflakeIdWorker worker = new SnowflakeIdWorker(0, 0);

    public static Long id(){
        return worker.nextId();
    }

    public static void main(String[] args) {
        System.out.println(worker.nextId());
        System.out.println(worker.nextId());
        System.out.println(worker.nextId());
        System.out.println(worker.nextId());
        System.out.println(worker.nextId());
    }
}
