/** Leonardo Bortolotti 568929
 * Mônica Colomera 570265 
 **/

/* Tela de listagem dos alunos cadastrados */

import javax.swing.*;
import java.util.*;
import java.util.List;
import java.awt.*;

public class JanelaAluno extends JDialog {
	private JButton btOK;
	private JButton btEditar;
	private ArrayList<Aluno> alunos;
	private JList<Aluno> jlAlunos;
	private Aluno E;
	private List<Aluno> A;
	
	public JanelaAluno(Frame owner) {
		super(owner,true);
		
		btOK = new JButton("OK");
		btEditar = new JButton("Editar");

		alunos = Dados.getInstance().getListAlunos(); // instancia a lista de Alunos
		
		DefaultListModel<Aluno> lm = new DefaultListModel<>();
		jlAlunos = new JList<>(lm);
		jlAlunos.setModel(lm);
		add(jlAlunos);
		
		for(int i=0;i<alunos.size();i++){
			lm.add(i,alunos.get(i)); // printa os elementos da lista de Alunos
		}	
		
		add(btOK, BorderLayout.WEST);
		add(btEditar, BorderLayout.EAST);
		
		btEditar.addActionListener((e)->{
			E = jlAlunos.getSelectedValue();
			EditarAluno aluno = new EditarAluno(E); // chama a janela de edição
			dispose();	
		});
		
		btOK.addActionListener((e)->{
			dispose();
		});
		
		setSize(300,300);
		setVisible(true);
	}
}

