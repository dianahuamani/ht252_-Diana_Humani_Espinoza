package dianahuamaniespinoza.view;

import dianahuamaniespinoza.controller.MatriculaController;
import dianahuamaniespinoza.controller.CursoController;
import dianahuamaniespinoza.model.Curso;
import dianahuamaniespinoza.model.Matricula;
import dianahuamaniespinoza.model.PDFExporter;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;


public class FrmMatricula extends JFrame {


    private JTextField txtDni;
    private JTextField txtNombres;
    private JTextField txtApellidos;
    private JTextField txtCorreo;
    private JTextField txtTelefono;
    private JTextField txtMonto;


    private JComboBox<Curso> cboCurso;


    private JRadioButton rbManana;
    private JRadioButton rbTarde;
    private JRadioButton rbNoche;


    private JCheckBox chkBeca;


    private JButton btnGuardar;
    private JButton btnActualizar;
    private JButton btnEliminar;
    private JButton btnReporte;


    private JTable tablaMatricula;

    private DefaultTableModel modelo;


    private MatriculaController controller;

    private CursoController cursoController;



    public FrmMatricula(){


        controller = new MatriculaController();

        cursoController = new CursoController();


        initComponents();

        cargarCursos();

        cargarTabla();

        eventos();

    }



    private void initComponents(){


        setTitle("Gestión de Matrículas");

        setSize(950,600);

        setLayout(null);



        JLabel l1 = new JLabel("DNI");
        l1.setBounds(20,20,100,25);
        add(l1);


        txtDni = new JTextField();
        txtDni.setBounds(120,20,150,25);
        add(txtDni);



        JLabel l2 = new JLabel("Nombres");
        l2.setBounds(20,60,100,25);
        add(l2);


        txtNombres = new JTextField();
        txtNombres.setBounds(120,60,150,25);
        add(txtNombres);



        JLabel l3 = new JLabel("Apellidos");
        l3.setBounds(20,100,100,25);
        add(l3);


        txtApellidos = new JTextField();
        txtApellidos.setBounds(120,100,150,25);
        add(txtApellidos);



        JLabel l4 = new JLabel("Correo");
        l4.setBounds(20,140,100,25);
        add(l4);


        txtCorreo = new JTextField();
        txtCorreo.setBounds(120,140,150,25);
        add(txtCorreo);



        JLabel l5 = new JLabel("Telefono");
        l5.setBounds(20,180,100,25);
        add(l5);


        txtTelefono = new JTextField();
        txtTelefono.setBounds(120,180,150,25);
        add(txtTelefono);



        JLabel l6 = new JLabel("Curso");
        l6.setBounds(320,20,100,25);
        add(l6);



        cboCurso = new JComboBox<>();
        cboCurso.setBounds(400,20,200,25);
        add(cboCurso);



        JLabel l7 = new JLabel("Turno");
        l7.setBounds(320,60,100,25);
        add(l7);



        rbManana = new JRadioButton("Mañana");
        rbManana.setBounds(400,60,90,25);


        rbTarde = new JRadioButton("Tarde");
        rbTarde.setBounds(490,60,80,25);


        rbNoche = new JRadioButton("Noche");
        rbNoche.setBounds(570,60,80,25);



        ButtonGroup grupo = new ButtonGroup();


        grupo.add(rbManana);
        grupo.add(rbTarde);
        grupo.add(rbNoche);



        add(rbManana);
        add(rbTarde);
        add(rbNoche);



        chkBeca = new JCheckBox("Tiene Beca");
        chkBeca.setBounds(320,100,120,25);
        add(chkBeca);



        JLabel l8 = new JLabel("Monto");
        l8.setBounds(320,140,100,25);
        add(l8);



        txtMonto = new JTextField();
        txtMonto.setBounds(400,140,150,25);
        add(txtMonto);



        btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(20,240,100,30);
        add(btnGuardar);



        btnActualizar = new JButton("Actualizar");
        btnActualizar.setBounds(140,240,110,30);
        add(btnActualizar);



        btnEliminar = new JButton("Eliminar");
        btnEliminar.setBounds(270,240,100,30);
        add(btnEliminar);



        btnReporte = new JButton("Reporte PDF");
        btnReporte.setBounds(400,240,130,30);
        add(btnReporte);



        modelo = new DefaultTableModel();


        modelo.addColumn("ID");
        modelo.addColumn("DNI");
        modelo.addColumn("Nombres");
        modelo.addColumn("Apellidos");
        modelo.addColumn("Correo");
        modelo.addColumn("Telefono");
        modelo.addColumn("Curso");
        modelo.addColumn("Turno");
        modelo.addColumn("Beca");
        modelo.addColumn("Monto");



        tablaMatricula = new JTable(modelo);


        JScrollPane scroll =
                new JScrollPane(tablaMatricula);


        scroll.setBounds(20,300,880,200);


        add(scroll);



        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }



// CONTINÚA EN PARTE 2
private void cargarCursos(){


    cboCurso.removeAllItems();


    ArrayList<Curso> cursos =
            cursoController.listarCursos();



    for(Curso c:cursos){

        cboCurso.addItem(c);

    }

}




    private void cargarTabla(){


        modelo.setRowCount(0);



        ArrayList<Matricula> lista =
                controller.listarMatriculas();




        for(Matricula m:lista){


            modelo.addRow(new Object[]{


                    m.getIdMatricula(),

                    m.getDni(),

                    m.getNombres(),

                    m.getApellidos(),

                    m.getCorreo(),

                    m.getTelefono(),

                    m.getNombreCurso(),

                    m.getTurno(),

                    m.isBeca(),

                    m.getMontoPago()


            });


        }


    }






    private String obtenerTurno(){


        if(rbManana.isSelected()){

            return "Mañana";

        }


        if(rbTarde.isSelected()){

            return "Tarde";

        }


        if(rbNoche.isSelected()){

            return "Noche";

        }


        return "";

    }






    private void eventos(){



        chkBeca.addActionListener(e -> {


            if(chkBeca.isSelected()){


                txtMonto.setText("0.00");

                txtMonto.setEnabled(false);


            }else{


                txtMonto.setEnabled(true);

                txtMonto.setText("");

            }


        });





        btnGuardar.addActionListener(e -> {

            guardar();

        });




        btnActualizar.addActionListener(e -> {

            actualizar();

        });




        btnEliminar.addActionListener(e -> {

            eliminar();

        });




        btnReporte.addActionListener(e -> {

            generarReporte();

        });




        tablaMatricula.getSelectionModel()
                .addListSelectionListener(e -> {


                    int fila =
                            tablaMatricula.getSelectedRow();



                    if(fila!=-1){


                        txtDni.setText(
                                modelo.getValueAt(fila,1).toString()
                        );


                        txtNombres.setText(
                                modelo.getValueAt(fila,2).toString()
                        );


                        txtApellidos.setText(
                                modelo.getValueAt(fila,3).toString()
                        );


                        txtCorreo.setText(
                                modelo.getValueAt(fila,4).toString()
                        );


                        txtTelefono.setText(
                                modelo.getValueAt(fila,5).toString()
                        );


                        txtMonto.setText(
                                modelo.getValueAt(fila,9).toString()
                        );



                        String turno =
                                modelo.getValueAt(fila,7).toString();



                        if(turno.equals("Mañana")){


                            rbManana.setSelected(true);


                        }else if(turno.equals("Tarde")){


                            rbTarde.setSelected(true);


                        }else{


                            rbNoche.setSelected(true);


                        }



                        chkBeca.setSelected(
                                Boolean.parseBoolean(
                                        modelo.getValueAt(fila,8).toString()
                                )
                        );


                    }


                });


    }







    private void guardar(){


        if(!txtDni.getText().matches("\\d{8}")){


            JOptionPane.showMessageDialog(
                    this,
                    "El DNI debe tener exactamente 8 números"
            );


            return;

        }



        Curso curso =
                (Curso)cboCurso.getSelectedItem();



        if(curso==null){


            JOptionPane.showMessageDialog(
                    this,
                    "Seleccione un curso"
            );


            return;

        }




        String turno =
                obtenerTurno();



        if(turno.equals("")){


            JOptionPane.showMessageDialog(
                    this,
                    "Seleccione un turno"
            );


            return;

        }



        double monto;



        try{


            monto = chkBeca.isSelected()
                    ? 0
                    : Double.parseDouble(txtMonto.getText());



        }catch(Exception e){



            JOptionPane.showMessageDialog(
                    this,
                    "Monto inválido"
            );


            return;

        }





        boolean resultado =
                controller.registrarMatricula(

                        txtDni.getText(),

                        txtNombres.getText(),

                        txtApellidos.getText(),

                        txtCorreo.getText(),

                        txtTelefono.getText(),

                        curso.getIdCurso(),

                        turno,

                        chkBeca.isSelected(),

                        monto

                );





        if(resultado){


            JOptionPane.showMessageDialog(
                    this,
                    "Matrícula registrada correctamente"
            );


            cargarTabla();

            limpiar();

        }


    }






    private void actualizar(){


        int fila =
                tablaMatricula.getSelectedRow();



        if(fila==-1){


            JOptionPane.showMessageDialog(
                    this,
                    "Seleccione una matrícula"
            );


            return;

        }




        Curso curso =
                (Curso)cboCurso.getSelectedItem();



        double monto;



        try{


            monto = chkBeca.isSelected()
                    ? 0
                    : Double.parseDouble(txtMonto.getText());



        }catch(Exception e){


            JOptionPane.showMessageDialog(
                    this,
                    "Monto inválido"
            );


            return;

        }




        Matricula m =
                new Matricula();



        m.setIdMatricula(
                Integer.parseInt(
                        modelo.getValueAt(fila,0).toString()
                )
        );



        m.setDni(txtDni.getText());

        m.setNombres(txtNombres.getText());

        m.setApellidos(txtApellidos.getText());

        m.setCorreo(txtCorreo.getText());

        m.setTelefono(txtTelefono.getText());

        m.setIdCurso(curso.getIdCurso());

        m.setTurno(obtenerTurno());

        m.setBeca(chkBeca.isSelected());

        m.setMontoPago(monto);





        if(controller.actualizarMatricula(m)){


            JOptionPane.showMessageDialog(
                    this,
                    "Matrícula actualizada correctamente"
            );


            cargarTabla();

            limpiar();

        }


    }






    private void eliminar(){


        int fila =
                tablaMatricula.getSelectedRow();



        if(fila==-1){


            JOptionPane.showMessageDialog(
                    this,
                    "Seleccione una matrícula"
            );


            return;

        }



        int id =
                Integer.parseInt(
                        modelo.getValueAt(fila,0).toString()
                );



        if(controller.eliminarMatricula(id)){


            JOptionPane.showMessageDialog(
                    this,
                    "Matrícula eliminada correctamente"
            );


            cargarTabla();

            limpiar();


        }


    }






    private void limpiar(){


        txtDni.setText("");

        txtNombres.setText("");

        txtApellidos.setText("");

        txtCorreo.setText("");

        txtTelefono.setText("");

        txtMonto.setText("");



        if(cboCurso.getItemCount()>0){

            cboCurso.setSelectedIndex(0);

        }



        rbManana.setSelected(false);

        rbTarde.setSelected(false);

        rbNoche.setSelected(false);



        chkBeca.setSelected(false);


        txtMonto.setEnabled(true);


    }







    private void generarReporte(){


        ArrayList<Matricula> lista =
                controller.listarMatriculas();



        if(lista.isEmpty()){


            JOptionPane.showMessageDialog(
                    this,
                    "No existen matrículas para generar reporte"
            );


            return;

        }




        PDFExporter.generarReporte(lista);




        JOptionPane.showMessageDialog(
                this,
                "Reporte PDF generado correctamente"
        );


    }



}