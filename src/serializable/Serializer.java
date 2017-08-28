package serializable;

import lombok.Data;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class Serializer {

    private String filePath;
    private String externalFilePath;
    private User user;
    private AdminUser adminUser;

    @Before
    public void init() {
        filePath = "E:\\test\\serializable\\user.ser";
        externalFilePath = "E:\\test\\serializable\\adminUser.ser";

        user = new User();
        user.setName("kyu");
        user.setAge(32);
        user.setSocialNumber("222222-1111111");

        adminUser = new AdminUser();
        adminUser.setName("adminKyu");
        adminUser.setAge(33);
        user.setSocialNumber("121212121-121212121");
    }

    @Test
    public void 객체직렬화테스트() throws IOException {
        FileOutputStream fos = new FileOutputStream(filePath);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(user);
        oos.close();

        assertThat(true, is(new File(filePath).isFile()));
    }

    @Test
    public void 객체역질렬화테스트() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(filePath);
        ObjectInputStream ois = new ObjectInputStream(fis);
        User user = (User) ois.readObject();
        ois.close();

        assertThat("kyu", is(user.getName()));
        assertThat(32, is(user.getAge()));
        assertThat(null, is(user.getSocialNumber()));
    }

    @Test
    public void externalWrite() throws IOException {
        FileOutputStream fos = new FileOutputStream(externalFilePath);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(adminUser);
        oos.close();

        assertThat(true, is(new File(externalFilePath).isFile()));
    }

    @Test
    public void externalRead() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(externalFilePath);
        ObjectInputStream ois = new ObjectInputStream(fis);
        AdminUser adminUser = (AdminUser) ois.readObject();

        assertThat("adminKyu", is(adminUser.getName()));
        assertThat(33, is(adminUser.getAge()));
        assertThat(null, is(adminUser.getSocialNumber()));
    }

    /**
     * clone 을 대체하는 copy 방법
     */
    @Test
    public void deppCopy() throws IOException, ClassNotFoundException {
        ObjectOutputStream outStream = null;
        ObjectInputStream inStream = null;

        try {
            ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
            outStream = new ObjectOutputStream(byteOut);
            outStream.writeObject(user);
            //always flush your stream
            outStream.flush();

            ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
            inStream = new ObjectInputStream(byteIn);
            User user = (User) inStream.readObject();

            assertThat("kyu", is(user.getName()));
            assertThat(32, is(user.getAge()));


        } catch (Exception e) {
            throw (e);
        } finally {
            // always close your streams in finally clauses
            outStream.close();
            inStream.close();
        }
    }
}

@Data
class User implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private int age;
    private transient String socialNumber;
}

@Data
class AdminUser implements Externalizable {
    private String name;
    private int age;
    private String socialNumber;

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(name);
        out.writeInt(age);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.name = (String) in.readObject();
        this.age = in.readInt();
    }
}