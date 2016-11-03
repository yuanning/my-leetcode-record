/**
 * Created by yn on 2016/10/17.
 */
public class PackageObject {

    private ChildObject childObject;

    public ChildObject getChildObject() {
        return childObject;
    }

    public void setChildObject(ChildObject childObject) {
        this.childObject = childObject;
    }

    public static void main(String[] args) {
        PackageObject packageObject = new PackageObject();
        ChildObject childObject = new ChildObject();
        childObject.setName("first");
        packageObject.setChildObject(childObject);

        System.out.println(childObject.toString());
        System.out.println(packageObject.getChildObject().getName());

        /*** start **/
        ChildObject cc = new ChildObject();
        cc.setName("it's new");
        ChildObject co = packageObject.getChildObject();
        co = cc;
        /*** end **/



        ChildObject childObject_ = packageObject.getChildObject();
        System.out.println(childObject_.toString());
        childObject_.setName("second");
        //此段代码中childObject 与 childObject_ 是否为同一个对象 (引用)
        childObject_ = null;
        //不添加此行 子对象是否修改
        //packageObject.setChildObject(childObject_);

        System.out.println(packageObject.getChildObject().getName());
    }
}


class ChildObject {

    private int id;
    private String name;
    private int code;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}


