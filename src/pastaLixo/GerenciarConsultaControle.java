package controle;

import dao.Dao;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import modelo.Animal;
import modelo.Consulta;
import modelo.Tutor;
import util.JsfUtil;


@Named
@ViewScoped
public class GerenciarConsultaControle implements Serializable {
    private Consulta consulta; 
    private Dao<Consulta> daoConsulta;
    private Dao<Animal> daoAnimal;

    
    private Animal animal;
    
    private List<Animal> listaAnimal;
    private Boolean mostraPopupAlteracao;
    private Boolean mostraEstadoPagamento;
     
    public Boolean getMostraEstadoPagamento() {
        return mostraEstadoPagamento;
    }

    public void setMostraEstadoPagamento(Boolean mostraEstadoPagamento) {
        this.mostraEstadoPagamento = mostraEstadoPagamento;
    }

    public List<Animal> getListaAnimal() {
        return listaAnimal;
    }

   
   
    
    @PostConstruct
    public void iniciar() {
     //   daoTutor = new Dao(Tutor.class);
        daoAnimal = new Dao(Animal.class);
        
        daoConsulta= new Dao(Consulta.class);
     //   listaTutores = daoTutor.listarTodos();
        listaAnimal = daoAnimal.listarTodos();
        animal = new Animal();
        
    }
    

    public void alterar(Consulta selecionado) {
        this.consulta = selecionado; 
        mostraPopupAlteracao = true;
    }

    
    public void excluir(Consulta excluido) {
        daoConsulta.excluir(excluido.getCodigo());
        listaAnimal = daoAnimal.listarTodos();
    }
    
    public void fecharPopupAlteracao(){
        mostraPopupAlteracao = false; 
    }
    
//    public String salvar() {
//        daoAnimal.inserir(animal);
//        animal = new Animal(); // limpa os campos 
//        JsfUtil.mostrarSucesso("Animal cadastrado");
//        listaAnimal = daoAnimal.listarTodos(); // atualiza tabela 
//        return null;
//    }
//
//    public String salvarAlteracao(){
//        daoAnimal.alterar(animal);
//        animal = new Animal(); // limpa os campos 
//        JsfUtil.mostrarSucesso("Usuário alterado");
//        listaAnimal = daoAnimal.listarTodos(); // atualiza tabela 
//        return null; 
//    }
//    
//    
//    
//    public List<Tutor> getListaTutores() {
//        return listaTutores;
//    }
//
//    public void setListaTutores(List<Tutor> listaTutores) {
//        this.listaTutores = listaTutores;
//    }
//
//    public Animal getAnimal() {
//        return animal;
//    }
//
//    public void setAnimal(Animal tutor) {
//        this.animal = tutor;
//    }
    public Boolean getMostraEstadoPagamento() {
        return mostraEstadoPagamento;
    }

    public void setMostraEstadoPagamento(Boolean mostraEstadoPagamento) {
        this.mostraEstadoPagamento = mostraEstadoPagamento;
    }
    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
}
