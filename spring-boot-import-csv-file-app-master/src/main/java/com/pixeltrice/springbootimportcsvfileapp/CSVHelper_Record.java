package com.pixeltrice.springbootimportcsvfileapp;

import org.apache.commons.csv.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class CSVHelper_Record {
  public static String TYPE = "text/csv";
  static String[] HEADERs = { "Recordid", "Locationid", "Number", "Productid" };

  public static boolean hasCSVFormat(MultipartFile file) {
 System.out.println(file.getContentType());
    if (TYPE.equals(file.getContentType())
    		|| file.getContentType().equals("application/vnd.ms-excel")) {
      return true;
    }

    return false;
  }

  public static List<Record> csvToTutorials(InputStream is) {
    try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
        CSVParser csvParser = new CSVParser(fileReader,
            CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

      List<Record> developerTutorialList = new ArrayList<>();

      Iterable<CSVRecord> csvRecords = csvParser.getRecords();

      for (CSVRecord csvRecord : csvRecords) {
          Record developerTutorial = new Record(
                  Long.parseLong(csvRecord.get("Recordid")),
                  Long.parseLong(csvRecord.get("Locationid")),
                  Long.parseLong(csvRecord.get("Number")),
                  Long.parseLong(csvRecord.get("Productid"))
            );

    	  developerTutorialList.add(developerTutorial);
      }

      return developerTutorialList;
    } catch (IOException e) {
      throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
    }
  }

  public static ByteArrayInputStream tutorialsToCSV(List<Record > developerTutorialList) {
    final CSVFormat format = CSVFormat.DEFAULT.withQuoteMode(QuoteMode.MINIMAL);

    try (ByteArrayOutputStream out = new ByteArrayOutputStream();
        CSVPrinter csvPrinter = new CSVPrinter(new PrintWriter(out), format);) {
      for (Record developerTutorial : developerTutorialList) {
        List<String> data = Arrays.asList(
                String.valueOf(developerTutorial.getRecordid()),
                String.valueOf(developerTutorial.getLocationid()),
                String.valueOf(developerTutorial.getNumber()),
                String.valueOf(developerTutorial.getProductid())
            );

        csvPrinter.printRecord(data);
      }

      csvPrinter.flush();
      return new ByteArrayInputStream(out.toByteArray());
    } catch (IOException e) {
      throw new RuntimeException("fail to import data to CSV file: " + e.getMessage());
    }
  }
}
