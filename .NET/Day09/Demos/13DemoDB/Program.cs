using System.Data;

namespace _13DemoDB
{
    internal class Program
    {
        static void Main(string[] args)
        {

            DataSet dataSet = new DataSet();

            DataTable table = new DataTable("Emp");

            DataColumn column1 = new DataColumn("No", typeof(int));
            DataColumn column2 = new DataColumn("Name", typeof(string));
            DataColumn column3 = 
                new DataColumn("Address", typeof(string));

            table.Columns.Add(column1);
            table.Columns.Add(column2);
            table.Columns.Add(column3);

            table.PrimaryKey = new DataColumn[] { column1 };


            DataRow row1 = table.NewRow();
            row1["No"] = 1;
            row1["Name"] = "abc";
            row1["Address"] = "pune";

            DataRow row2 = table.NewRow();
            row2["No"] = 2;
            row2["Name"] = "xyz";
            row2["Address"] = "pune";

            DataRow row3 = table.NewRow();
            row3["No"] = 3;
            row3["Name"] = "pqr";
            row3["Address"] = "pune";

            table.Rows.Add(row1);
            table.Rows.Add(row2);
            table.Rows.Add(row3);

            dataSet.Tables.Add(table);

            dataSet.WriteXml("D:\\IACSD\\IACSDDemos\\data.xml");
            dataSet.WriteXmlSchema("D:\\IACSD\\IACSDDemos\\schema.xml");

        }
    }
}
