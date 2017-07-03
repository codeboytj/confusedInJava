package cumt.tj.learn.wrapper;

/**
 * Created by sky on 17-7-3.
 * 基本类型与其包装类
 */
public class PrimitiveAndWrapper {

    public int primitiveCount;
    public Integer wrapCount=Integer.valueOf(0);

    public void changePrimitive(int count){
        count++;
    }

    public void changeWrapper(Integer count){
        count++;
    }

    public static void main(String[] args) {
        PrimitiveAndWrapper primitiveAndWrapper=new PrimitiveAndWrapper();
        primitiveAndWrapper.changePrimitive(primitiveAndWrapper.primitiveCount);
        primitiveAndWrapper.changeWrapper(primitiveAndWrapper.wrapCount);
        System.out.println(primitiveAndWrapper.primitiveCount);
        System.out.println(primitiveAndWrapper.wrapCount);
    }

}
