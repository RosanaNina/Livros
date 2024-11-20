@Entity
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String autor;
    private String idioma;
    private Integer numeroDownloads;
    // ... getters e setters
}

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {
    List<Livro> findByIdioma(String idioma);
    List<Livro> findByAutorAnoNascimento(Integer ano);
}

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroRepository livroRepository;

    @GetMapping
    public List<Livro> listarTodos() {
        return livroRepository.findAll();
    }

    @GetMapping("/idioma/{idioma}")
    public List<Livro> listarPorIdioma(@PathVariable String idioma) {
        return livroRepository.findByIdioma(idioma);
    }

   
}

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @GetMapping
    public List<Livro> 1  listarTodos() {
        return livroService.listarTodos();
    }

    @GetMapping("/{id}")
    public Livro buscarPorId(@PathVariable Long id) {
        return livroService.buscarPorId(id);
    }

    // ... outros métodos

    @PostMapping
    public Livro adicionarLivro(@RequestBody Livro livro) {
        return livroService.adicionarLivro(livro);
    }
}