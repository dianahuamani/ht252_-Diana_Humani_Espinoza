package dianahuamaniespinoza.model;

import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.util.ArrayList;


public class PDFExporter {


    public static void generarReporte(ArrayList<Matricula> lista){


        String ruta = "Reporte_Matriculas.pdf";


        try{


            Document documento = new Document();


            PdfWriter.getInstance(
                    documento,
                    new FileOutputStream(ruta)
            );


            documento.open();



            Font titulo = FontFactory.getFont(
                    FontFactory.HELVETICA_BOLD,
                    18
            );



            Paragraph encabezado =
                    new Paragraph(
                            "Reporte de Matriculas",
                            titulo
                    );


            encabezado.setAlignment(
                    Element.ALIGN_CENTER
            );


            documento.add(encabezado);


            documento.add(
                    new Paragraph(" ")
            );



            PdfPTable tabla =
                    new PdfPTable(7);



            tabla.addCell("DNI");
            tabla.addCell("Alumno");
            tabla.addCell("Curso");
            tabla.addCell("Turno");
            tabla.addCell("Beca");
            tabla.addCell("Monto");
            tabla.addCell("Estado");



            for(Matricula m : lista){


                tabla.addCell(
                        m.getDni()
                );


                tabla.addCell(
                        m.getNombres()
                                + " "
                                + m.getApellidos()
                );


                tabla.addCell(
                        m.getNombreCurso()
                );


                tabla.addCell(
                        m.getTurno()
                );


                tabla.addCell(
                        m.isBeca()
                                ? "SI"
                                : "NO"
                );


                tabla.addCell(
                        String.valueOf(
                                m.getMontoPago()
                        )
                );


                tabla.addCell(
                        m.getEstado()==1
                                ? "Activo"
                                : "Cancelado"
                );


            }



            documento.add(tabla);



            documento.close();



            System.out.println(
                    "PDF generado correctamente: "
                            + ruta
            );


        }catch(Exception e){


            System.out.println(
                    "Error al generar PDF"
            );


            e.printStackTrace();

        }


    }


}