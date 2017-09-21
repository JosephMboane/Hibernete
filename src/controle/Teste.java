/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.util.Date;
import javax.swing.JOptionPane;
import modelo.EstadoCivil;
import modelo.Morada;
import modelo.Pessoa;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author joseph
 */
public class Teste {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Pessoa p = new Pessoa();
        p.setContacto(823);
        p.setNome("Joseph Mboane");
        p.setEstdoCivil(EstadoCivil.VIUVO);
        p.setDataNasc(new Date());
        Morada morada = new Morada();
        morada.setNumero(50);
        morada.setRua("18");
        morada.setCidade("Maputo, PC");


        p.setMorada(morada);

        SessionFactory factory = new Configuration().configure("controle/hibernate.cfg.xml").buildSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();

        session.save(p);
        session.getTransaction().commit();
        JOptionPane.showMessageDialog(null, "Cadastrado Com Sucesso");
        Pessoa pessoaBanco = (Pessoa) session.get(Pessoa.class, 3);
        System.out.println("Nome:" + pessoaBanco.getNome());
        session.close();
    }

}
