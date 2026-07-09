package dianahuamaniespinoza.view;


import dianahuamaniespinoza.controller.CursoController;
import dianahuamaniespinoza.model.Curso;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;



public class FrmCurso extends JFrame {


    private JTextField txtNombre;
    private JTextField txtDescripcion;
    private JTextField txtDuracion;


    private JButton btnGuardar;
    private JButton btnActualizar;
    private JButton btnEliminar;


    private JTable tablaCurso;

    private DefaultTableModel modelo;


    private CursoController controller;


    private int idSeleccionado = 0;



    public FrmCurso(){


        controller = new CursoController();


        initComponents();


        cargarTabla();


        eventos();


    }





    private void initComponents(){


        setTitle("Gestión de Cursos");


        setSize(700,500);


        setLayout(null);



        JLabel l1 =
                new JLabel("Nombre Curso");


        l1.setBounds(20,20,120,25);


        add(l1);



        txtNombre =
                new JTextField();


        txtNombre.setBounds(
                150,
                20,
                200,
                25
        );


        add(txtNombre);






        JLabel l2 =
                new JLabel("Descripción");


        l2.setBounds(
                20,
                60,
                120,
                25
        );


        add(l2);



        txtDescripcion =
                new JTextField();


        txtDescripcion.setBounds(
                150,
                60,
                200,
                25
        );


        add(txtDescripcion);






        JLabel l3 =
                new JLabel("Duración");


        l3.setBounds(
                20,
                100,
                120,
                25
        );


        add(l3);



        txtDuracion =
                new JTextField();


        txtDuracion.setBounds(
                150,
                100,
                200,
                25
        );


        add(txtDuracion);






        btnGuardar =
                new JButton("Guardar");


        btnGuardar.setBounds(
                20,
                150,
                100,
                30
        );


        add(btnGuardar);






        btnActualizar =
                new JButton("Actualizar");


        btnActualizar.setBounds(
                140,
                150,
                110,
                30
        );


        add(btnActualizar);






        btnEliminar =
                new JButton("Eliminar");


        btnEliminar.setBounds(
                270,
                150,
                100,
                30
        );


        add(btnEliminar);






        modelo =
                new DefaultTableModel();



        modelo.addColumn("ID");

        modelo.addColumn("Nombre");

        modelo.addColumn("Descripción");

        modelo.addColumn("Duración");



        tablaCurso =
                new JTable(modelo);



        JScrollPane scroll =
                new JScrollPane(tablaCurso);



        scroll.setBounds(
                20,
                220,
                620,
                180
        );



        add(scroll);



        setDefaultCloseOperation(
                JFrame.DISPOSE_ON_CLOSE
        );

    }







    private void cargarTabla(){


        modelo.setRowCount(0);



        ArrayList<Curso> lista =
                controller.listarCursos();



        for(Curso c:lista){



            modelo.addRow(
                    new Object[]{

                            c.getIdCurso(),

                            c.getNombreCurso(),

                            c.getDescripcion(),

                            c.getDuracion()

                    }
            );


        }


    }








    private void eventos(){



        btnGuardar.addActionListener(e -> {


            guardarCurso();


        });






        btnActualizar.addActionListener(e -> {


            actualizarCurso();


        });







        btnEliminar.addActionListener(e -> {


            eliminarCurso();


        });







        tablaCurso.getSelectionModel()
                .addListSelectionListener(e -> {



                    int fila =
                            tablaCurso.getSelectedRow();



                    if(fila >=0){



                        idSeleccionado =
                                Integer.parseInt(
                                        tablaCurso.getValueAt(
                                                fila,0
                                        ).toString()
                                );



                        txtNombre.setText(
                                tablaCurso.getValueAt(
                                        fila,1
                                ).toString()
                        );



                        txtDescripcion.setText(
                                tablaCurso.getValueAt(
                                        fila,2
                                ).toString()
                        );



                        txtDuracion.setText(
                                tablaCurso.getValueAt(
                                        fila,3
                                ).toString()
                        );

                    }


                });



    }








    private void guardarCurso(){



        boolean resultado =
                controller.registrarCurso(

                        txtNombre.getText(),

                        txtDescripcion.getText(),

                        txtDuracion.getText()

                );



        if(resultado){


            JOptionPane.showMessageDialog(
                    this,
                    "Curso registrado"
            );


            cargarTabla();


            limpiar();


        }


    }








    private void actualizarCurso(){



        if(idSeleccionado==0){


            JOptionPane.showMessageDialog(
                    this,
                    "Seleccione un curso"
            );


            return;

        }




        boolean resultado =
                controller.actualizarCurso(

                        idSeleccionado,

                        txtNombre.getText(),

                        txtDescripcion.getText(),

                        txtDuracion.getText()

                );




        if(resultado){


            JOptionPane.showMessageDialog(
                    this,
                    "Curso actualizado"
            );


            cargarTabla();


            limpiar();


        }


    }









    private void eliminarCurso(){



        if(idSeleccionado==0){


            JOptionPane.showMessageDialog(
                    this,
                    "Seleccione un curso"
            );


            return;

        }




        boolean resultado =
                controller.eliminarCurso(
                        idSeleccionado
                );



        if(resultado){


            JOptionPane.showMessageDialog(
                    this,
                    "Curso eliminado correctamente"
            );


            cargarTabla();


            limpiar();


        }


    }









    private void limpiar(){


        txtNombre.setText("");

        txtDescripcion.setText("");

        txtDuracion.setText("");

        idSeleccionado=0;


    }


}