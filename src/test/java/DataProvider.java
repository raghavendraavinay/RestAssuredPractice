public class DataProvider {
    @org.testng.annotations.DataProvider(name = "DataDriven")
    public Object[][] dataProvider(){
//        Object[][] data = new Object[2][3];
//        data[0][0] = "Albert";
//        data[0][1] = "Einstein";
//        data[0][2] = 2;
//
//        data[1][0] = "Thomas";
//        data[1][1] = "Edison";
//        data[1][2] = 1;
//
//        return data;
        return new Object[][]{
                {"Graham","Bell",2},
                {"Henry","Ford",1}
        };
    }

    @org.testng.annotations.DataProvider(name = "deleteData")
    public Object[] dataForDelete(){
        return new Object[]{7,8};
    }
}
