package imb.lh.p3.clases.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import imb.lh.p3.clases.entity.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

}
