// import java.io.OutputStream;
// import java.net.HttpURLConnection;
// import java.net.URL;

// public class ApiService {

//     public static void savePatient(
//             String name,
//             int age,
//             String disease
//     ) {

//         try {

//             URL url =
//                     new URL("http://localhost:8081/patients");

//             HttpURLConnection con =
//                     (HttpURLConnection) url.openConnection();

//             con.setRequestMethod("POST");

//             con.setRequestProperty(
//                     "Content-Type",
//                     "application/json"
//             );

//             con.setDoOutput(true);

//             String jsonInput = String.format(
//                     """
//                     {
//                        "name":"%s",
//                        "age":%d,
//                        "disease":"%s"
//                     }
//                     """,
//                     name,
//                     age,
//                     disease
//             );

//             try(OutputStream os = con.getOutputStream()) {

//                 byte[] input =
//                         jsonInput.getBytes("utf-8");

//                 os.write(input, 0, input.length);
//             }

//             System.out.println(
//                     "Response Code : "
//                             + con.getResponseCode()
//             );

//         } catch (Exception e) {

//             e.printStackTrace();
//         }
//     }
// }


import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiService {

    public static void savePatient(
            String name,
            int age,
            String disease
    ) {

        try {

            URL url =
                    new URL("http://13.51.166.139:8081/patients");
// http://localhost:8081/patients
            HttpURLConnection con =
                    (HttpURLConnection) url.openConnection();

            con.setRequestMethod("POST");

            con.setRequestProperty(
                    "Content-Type",
                    "application/json"
            );

            con.setDoOutput(true);

            String jsonInput = String.format(
                    """
                    {
                       "name":"%s",
                       "age":%d,
                       "disease":"%s"
                    }
                    """,
                    name,
                    age,
                    disease
            );

            try(OutputStream os = con.getOutputStream()) {

                byte[] input =
                        jsonInput.getBytes("utf-8");

                os.write(input, 0, input.length);
            }

            System.out.println(
                    "Response Code : "
                            + con.getResponseCode()
            );

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}