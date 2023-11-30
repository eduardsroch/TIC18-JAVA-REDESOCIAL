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

    public void autenticar(String nome, String senha) throws Exception {
        for (Usuario usuario : usuarios) {
            if (usuario.getNome().equals(nome) && usuario.getSenha().equals(senha)) {
                Sessao sessao = new Sessao(usuario);
                sessoes.add(sessao);
            }
        }
        throw new Exception("Usuário ou senha inválidos");
    }

    public void criarAmizade(Sessao sessao, String nomeDoAmigo) {
        sessao.getUsuario().criarAmizade(nomeDoAmigo);
    }

    public void desfazerAmizade(Sessao sessao, String nomeDoExAmigo) {
        sessao.getUsuario().desfazerAmizade(nomeDoExAmigo);
    }

    public void incluirPostagem(Sessao sessao, String postagem) {
        sessao.getUsuario().incluirPostagem(postagem);
    }

    public ArrayList<String> listarPostagens(Sessao sessao) {
        return sessao.getUsuario().listarPostagens();
    }
}
