package basis.proxy;

/**
 * @author JerryWan
 * @descripion TODO
 * @date 2019-11-10  11:19
 */
public class User {

    private String name;

    private int age;

    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return com.google.common.base.MoreObjects.toStringHelper(this)
                .add("name", name)
                .add("age", age)
                .add("address", address)
                .toString();
    }
}
