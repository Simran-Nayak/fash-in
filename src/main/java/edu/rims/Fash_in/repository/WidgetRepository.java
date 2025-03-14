package edu.rims.Fash_in.repository;

import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import edu.rims.Fash_in.constant.WidgetStatus;
import edu.rims.Fash_in.entity.Widget;

public interface WidgetRepository extends JpaRepository<Widget, String> {
    // List<Widget> findByWidgetStatus(WidgetStatus widgetStatus, Sort sort);
    // Object findByWidgetStatus(WidgetStatus active, org.springframework.data.domain.Sort by); 
} 
