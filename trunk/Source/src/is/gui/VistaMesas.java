package is.gui;

import is.restaurante.ComandaInfo;
import is.restaurante.Mesa;
import is.restaurante.MesaInfo;
import is.restaurante.MesaObserver;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
/**
 * Muestra todas las mesas
 * Al elegir una mesa permite añadir o eliminar una comanda para esa mesa.
 * TODO lo está arreglando villarín, con los cambios que hizo el y los que hizo Jaime
 * @author JaimeDan
 * @author Villarin
 */
public class VistaMesas extends JPanel implements MesaObserver {

	public VistaMesas(final GUIController controller) {
		this.restController = controller;
		this.mesas = this.restController.requestMesas();
		this.setLayout(new BorderLayout());
		comandasPanel = new JPanel[mesas.length];
		comandasContainer = new JPanel();
		final CardLayout comandasLayout = new CardLayout();
		comandasContainer.setLayout(comandasLayout);
		JPanel cardPanel = new JPanel();
		cardPanel.setLayout(comandasLayout);

		final TitledBorder title = new TitledBorder("Mesa");
		cardPanel.setBorder(title);
		/*
		 * Inicializamos los JPanel que contendrán las comandas de cada mesa y
		 * los botones de control añadir, eliminar y editar comanda
		 */

		for (int j = 0; j < mesas.length; j++) {
			comandasPanel[j] = new JPanel();
			TitledBorder titulo = BorderFactory.createTitledBorder("Mesa "
					+ (j + 1));
			comandasPanel[j].setBorder(titulo);
			setComandasPanel(j);

		}
		// comandas = restController.getMesa(j).getListaComandas();

		/*
		 * for (int i=0; i< mesas.length; i++){ comandasPanel[i] = new JPanel();
		 * comandasPanel[i].setLayout(new FlowLayout());
		 * comandasPanel[i].setBorder(title);
		 * 
		 * }
		 */
		/*
		 * Se los añadimos al contenedor padre, mierda esto lo quito porque ya
		 * estaba en el setcomandasPanel
		 */
		// for (Integer i = 0; i < mesas.length; i++)
		// comandasContainer.add(comandasPanel[i], i.toString());

		/* Creamos un panel con las mesas, usando un flowlayout */
		JPanel panelMesas = new JPanel();
		panelMesas.setLayout(new FlowLayout());
		// this.restController.requestMesas();
		// this.restController.pedirMesas();
		/*
		 * Para cada mesa añadimos un listener que hara que el cardlayout
		 * muestre el panel de comandas correspondiente a la mesa j
		 */
		for (int i = 0; i < mesas.length; i++) {
			// el numero de mesa siempre es el mismo que el indice
			final Integer j = mesas[i].getNumeroMesa();// para que pueda ser
														// utilizado por el
														// listener

			//se pone con getnumeromesa, da igual que empiece por 0, porque en otros sitios esta asi
			JButton mesa = new JButton("Mesa " + (mesas[i].getNumeroMesa()));
			mesa.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					numMesa = j;
					title.setTitle("Mesa " + (j + 1));
					/*
					 * Comanda[] comandas = new
					 * Comanda[controller.getMesa(j).getListaComandas().length];
					 * 
					 * for (int i = 0; i< comandas.length; i++)
					 */
					// comandas = restController.getMesa(j).getListaComandas();

					// setComandasPanel(j);
					// comandasPanel[j].add(new JLabel("Bubidibu"),
					// BorderLayout.SOUTH);

					/*
					 * El card layout debe mostrar en comandasContainer las
					 * comandas de la mesa j, (Recordemos que j.toString era la
					 * clave para las comandas de la mesa j Aquí falla el
					 * programa Mirar los .java realizar pedido y
					 * cardLayoutExample para ver como funciona el card layout
					 */
					comandasLayout.show(
					/* comandasPanel[j] */comandasContainer, j.toString());

				}

			});
			panelMesas.add(mesa);
		}
		/* Añadimos el panel con las mesas al norte */
		this.add(panelMesas, BorderLayout.NORTH);
		/*
		 * Añadimos el contenedor padre con las comandas por cada mesa en el
		 * centro
		 */
		this.add(comandasContainer, BorderLayout.CENTER);

		JFrame frame = new JFrame("Comandas por mesa");

		frame.setVisible(true);
		// frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.add(this);
		frame.pack();

	}

	public void setComandasPanel(Integer numeroMesa) {
		//se deja con numeroMesa
		TitledBorder title = new TitledBorder("Mesa " + (numeroMesa));
		comandas = restController.getMesa(numeroMesa).getListaComandas();
		comandasPanel[numeroMesa].setBorder(title);
		comandasPanel[numeroMesa].setLayout(new BorderLayout());
		JPanel comanditasPanel = new JPanel();
		/*
		 * Se crea un JPanel con Flow layout para añadir como botones las
		 * comandas de las mesas igual en vez de botones se podrian usar
		 * JRadioButtons
		 */
		comanditasPanel.setLayout(new FlowLayout());
		/* Si la mesa tiene comandas, es decir, comandas!= null */
		if (comandas != null) {
			/* Creamos los botones con las comandas */
			for (int i = 0; i < comandas.length; i++) {
				final int j = i;
				// no me acuerdo porque puse i+1
				JButton comandaMesa = new JButton("Comanda " + i);
				comandaMesa.addActionListener(new ActionListener() {
					/*
					 * Al seleccionar una comanda guardaremos en un atributo qué
					 * comanda hemos elegido
					 */
					@Override
					public void actionPerformed(ActionEvent e) {
						comandaSelected = j;
						// restController.avisaComanda(numMesa,
						// comandaSelected);
					}

				});
				/* Añadimos el boton al panel con las comandas */
				comanditasPanel.add(comandaMesa);
			}
			/*
			 * Despues de haber creado el panel con las comandas lo añadimos al
			 * centro de comandasPanel[numPanel]
			 */
			comandasPanel[numeroMesa].add(comanditasPanel, BorderLayout.CENTER);
		}

		/* Creamos un JPanel que tendrá los botones de Editar, añadir y eliminar */
		JPanel botoncitosPanel = new JPanel();
		botoncitosPanel.setLayout(new FlowLayout());

		JButton editarComanda = new JButton("Editar");
		editarComanda.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

			}

		});
		botoncitosPanel.add(editarComanda);

		JButton añadirComanda = new JButton("Añadir");
		añadirComanda.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (/* comandaSelected != -1 && */numMesa != -1) {
					restController.requestNewCommand(numMesa);
					new RealizarPedido(restController, numMesa, comandas.length);
				}
			}

		});
		botoncitosPanel.add(añadirComanda);

		JButton eliminarComanda = new JButton("Eliminar");
		eliminarComanda.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (comandaSelected != -1 && numMesa != -1) {
					restController.eliminarComanda(numMesa, comandaSelected);
				}
			}

		});
		botoncitosPanel.add(eliminarComanda);
		/*
		 * Se añade el Panel con los botones de control al
		 * comandasPanel[numeroMesa]
		 */
		comandasPanel[numeroMesa].add(botoncitosPanel, BorderLayout.SOUTH);

		/*
		 * Se añade al JPanel padre el comandasPanel[numeroMesa], pasandole como
		 * clave el numero de mesa en string
		 */
		comandasContainer.add(comandasPanel[numeroMesa], numeroMesa.toString());

		// comandasContainer.add(editarComanda);
		// comandasContainer.add(añadirComanda);
		// comandasContainer.add(eliminarComanda);
	}//

	@Override
	public void cambioOcurrido(final ComandaInfo[] comandas, int numeroMesas) {
		this.comandas = comandas;
		comandasPanel[numeroMesas].removeAll();
		//se deja con numerMesas porque las mesas van desde 0 hasta n-1 en otros sitios
		TitledBorder title = new TitledBorder("Mesa " + (numeroMesas ));

		comandasPanel[numeroMesas].setBorder(title);
		comandasPanel[numeroMesas].setLayout(new BorderLayout());
		JPanel comanditasPanel = new JPanel();
		/*
		 * Se crea un JPanel con Flow layout para añadir como botones las
		 * comandas de las mesas igual en vez de botones se podrian usar
		 * JRadioButtons
		 */
		comanditasPanel.setLayout(new FlowLayout());
		/* Si la mesa tiene comandas, es decir, comandas!= null */
		if (comandas != null) {
			/* Creamos los botones con las comandas */
			for (int i = 0; i < comandas.length; i++) {
				final int j = i;
				// no me acuerdo porque puse i+1
				JButton comandaMesa = new JButton("Comanda " + i);
				comandaMesa.addActionListener(new ActionListener() {
					/*
					 * Al seleccionar una comanda guardaremos en un atributo qué
					 * comanda hemos elegido
					 */
					@Override
					public void actionPerformed(ActionEvent e) {
						comandaSelected = j;
						// restController.avisaComanda(numMesa,
						// comandaSelected);
					}

				});
				/* Añadimos el boton al panel con las comandas */
				comanditasPanel.add(comandaMesa);
			}
			/*
			 * Despues de haber creado el panel con las comandas lo añadimos al
			 * centro de comandasPanel[numPanel]
			 */
			comandasPanel[numeroMesas]
					.add(comanditasPanel, BorderLayout.CENTER);
		}

		/* Creamos un JPanel que tendrá los botones de Editar, añadir y eliminar */
		JPanel botoncitosPanel = new JPanel();
		botoncitosPanel.setLayout(new FlowLayout());

		JButton editarComanda = new JButton("Editar");
		editarComanda.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

			}

		});
		botoncitosPanel.add(editarComanda);

		JButton añadirComanda = new JButton("Añadir");
		añadirComanda.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (/* comandaSelected != -1 && */numMesa != -1) {
					restController.requestNewCommand(numMesa);
					new RealizarPedido(restController, numMesa, comandas.length);
				}
			}

		});
		botoncitosPanel.add(añadirComanda);

		JButton eliminarComanda = new JButton("Eliminar");
		eliminarComanda.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (comandaSelected != -1 && numMesa != -1) {
					restController.eliminarComanda(numMesa, comandaSelected);
				}
			}

		});
		botoncitosPanel.add(eliminarComanda);
		/*
		 * Se añade el Panel con los botones de control al
		 * comandasPanel[numeroMesa]
		 */
		comandasPanel[numeroMesas].add(botoncitosPanel, BorderLayout.SOUTH);

	}

	private JPanel comandasContainer;

	private GUIController restController;
	private MesaInfo[] mesas;
	private ComandaInfo[] comandas;
	private JPanel[] comandasPanel;
	int comandaSelected = -1;
	private int numMesa = 0;

	@Override
	public void facturaGenerada(String factura) {
		// TODO Auto-generated method stub

	}

}
