package instance;

import java.lang.reflect.InvocationTargetException;

public class ReflectServiceImpl2 {
    private Integer id;
    private String name;
    public ReflectServiceImpl2(Integer id,String name){
        this.id = id;
        this.name = name;
    }
    public void sayHello(){
        System.out.println("id为 > "+id+" say hello for "+name);
    }

    //反射带有参数的构建方法
    public ReflectServiceImpl2 getInstance(){
        ReflectServiceImpl2 object = null;
        try {
            object = (ReflectServiceImpl2)Class.forName("instance.ReflectServiceImpl2").getConstructor(Integer.class,String.class).newInstance(1,"张三");
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return object;
    }
}
