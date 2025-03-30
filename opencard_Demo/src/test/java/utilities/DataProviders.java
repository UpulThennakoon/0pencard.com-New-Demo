package utilities;

import org.testng.annotations.DataProvider;

import java.io.IOException;

public class DataProviders
{
    @DataProvider(name="LoginData")
    public String [][] getData() throws IOException {
        String path=".\\testdata\\Opencart_LoginData.xlsx";
        Excelutility xlutil=new Excelutility(path);

        int totalrow=xlutil.getRowCount("Sheet1");
        int totalcols=xlutil.getCellCount("Sheet1",1);

        String loaindata[][]=new String[totalrow][totalcols];

        for(int i=1 ;i<=totalrow; i++)
        {
            for(int j=0 ; j<totalcols ; j++)
            {
                loaindata[i-1][j]=xlutil.getCellData("Sheet1",i,j);

            }

        }
        return loaindata;
    }


}
