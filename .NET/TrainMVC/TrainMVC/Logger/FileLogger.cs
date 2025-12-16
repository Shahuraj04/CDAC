namespace TrainMVC.Logger
{
    public class FileLogger
    {
        //private static FileLogger _fileLogger = new FileLogger();

        //private FileLogger() { }

        //public static FileLogger CurrentLogger {
        //    get { return _fileLogger; }
        //}

        //public void log(string message) {

        //    string path = "D:\\CDAC\\.NET\\TrainMVC\\TrainMVC\\log.txt";
        //    FileStream fileStream = null;
        //    if (File.Exists(path))
        //    {
        //        fileStream = new FileStream(path, FileMode.Append, FileAccess.Write);
        //    }
        //    else { 
        //        fileStream = new FileStream(path, FileMode.Create, FileAccess.Write);
        //    }
        // StreamWriter writer = new StreamWriter(fileStream);
        //    writer.WriteLine(DateTime.Now.ToString() + " : " + message);
        //    writer.Close();
        //    fileStream.Close();



        //}

        private static FileLogger _fileLogger = new FileLogger();

        private FileLogger() { }

        public static FileLogger CurrentLogger {
            get { return _fileLogger; }
        }

        public void log(string message) {

            string path = "D:\\CDAC\\.NET\\TrainMVC\\TrainMVC\\log.txt";
            FileStream fileStream = null;
            if (File.Exists(path))
            {
                fileStream = new FileStream(path, FileMode.Append, FileAccess.Write);
            }
            else { 
                fileStream = new FileStream(path, FileMode.Create, FileAccess.Write);
            }
         StreamWriter writer = new StreamWriter(fileStream);
            writer.WriteLine(DateTime.Now.ToString() + " : " + message);
            writer.Close();
            fileStream.Close();



        }
    }
}
