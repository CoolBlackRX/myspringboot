package proxypattern;

/**
 * @Description
 * @Author zhaohq
 * @Date 2020/8/18
 */
public class Father {
    private Son son;

    public Father(Son son) {
        this.son = son;
    }

    public void findLove(){
        /**
         * -------------------
         * 父亲掌握小区内所有女孩子的信息
         * 现在可以为儿子物色一个对象
         * 可以认为代理掌握了所有目标的信息
         * 就差你想要啥了
         * -------------------
         */
        System.out.println("父亲物色对象");
        /**
         * -------------------
         * 父亲获取到儿子的相亲要求
         * 可以认为获取到一个匹配的要求
         * -------------------
         */
        this.son.findLover();
        /**
         * -------------------
         * 父亲把女孩子介绍儿子
         * 可以认为将二者匹配
         * -------------------
         */
        System.out.println("双方同意交往，确立关系");
    }
}
