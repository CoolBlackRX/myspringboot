package reflection;

/**
 * @Description
 * @Author zhaohq
 * @Date 2020/8/14
 */
public class Book {
    public Integer id = 1;
    public String name = "zhq";
    public String author = "zhaohq";

    public void Test() {
        System.out.println("你通过Java反射找到我了");
    }

    public Book() {
    }

    public Book(Integer id, String name, String author) {
        this.id = id;
        this.name = name;
        this.author = author;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                '}';
    }


}
