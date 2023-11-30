import java.util.Calendar;

class Sessao {
    private Usuario usuario;
    private Calendar inicio;
    private Calendar fim;

    public Sessao(Usuario usuario) {
        this.usuario = usuario;
        this.inicio = Calendar.getInstance();
        this.fim = null;
    }

    public void setFim(Date fim) {
        this.fim = fim;
    }
}

class Sistema {
    private ArrayList<Usuario> usuarios;
    private ArrayList<Sessao> sessoes;

    public Sistema() {
        this.usuarios = new ArrayList<>();
        this.sessoes = new ArrayList<>();
    }

    public Sessao autenticar(String nome, String senha) throws Exception {
        for (Usuario usuario : usuarios) {
            if (usuario.getNome().equals(nome) && usuario.getSenha().equals(senha)) {
                Sessao sessao = Usuario.logar(usuario);
                sessoes.add(sessao);
                return sessao;
            }
        }
        throw new Exception("Usuário ou senha inválidos");
    }

    public void criarAmizade(Usuario amigo) {
        if (!amigos.contains(amigo)) {
            amigos.add(amigo);
            amigo.add(this);
            System.out.println(this.nome + " e " + amigo.getNome() + " são agora amigos.");
        } else {
            System.out.println(this.nome + " e " + amigo.getNome() + " já são amigos.");
        }
    }

    public void desfazerAmizade(Usuario exAmigo) {
        if (amigos.contains(exAmigo)) {
            amigos.remove(exAmigo);
            exAmigo.remove(this);
            System.out.println(this.nome + " e " + exAmigo.getNome() + " não são mais amigos.");
        } else {
            System.out.println(this.nome + " e " + exAmigo.getNome() + " não eram amigos.");
        }
    }

    public void incluirPostagem(String postagem) {
        listaPostagens.add(postagem);
        System.out.println("Postagem adicionada por " + this.nome + ": " + postagem);
    }

    public ArrayList<String> listarPostagens(Sessao sessao) {
        return sessao.getUsuario().listarPostagens();
    }
}
