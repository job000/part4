import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public interface Fileable {
  void writeData(PrintWriter out) throws IOException;

  void readData(Scanner in) throws IOException;
}