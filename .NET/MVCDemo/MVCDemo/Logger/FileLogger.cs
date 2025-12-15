namespace MVCDemo.Logger
{
    public class FileLogger
    {
        private static FileLogger _fileLogger = new FileLogger();

        private FileLogger() { }
        public static FileLogger CurrentLogger
        {
            get { return _fileLogger; }
        }

        public void Log(string message) {
            string path = "D:\\CDAC\\.NET\\MVCDemo\\Log.txt";

            FileStream stream = null;
            if (File.Exists(path))
            {
                stream = new FileStream(path, FileMode.Append, FileAccess.Write);
            }
            else { 
                stream = new FileStream(path, FileMode.Create, FileAccess.Write);
            }
            StreamWriter writer = new StreamWriter(stream);

            writer.WriteLine(DateTime.Now.ToString() + " : " + message);
            writer.Close();
            stream.Close();


        }
    }
}
