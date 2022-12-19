package ru.levelup.homework6.dao.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import ru.levelup.homework6.dao.CityDao;
import ru.levelup.homework6.model.City;

import java.sql.Types;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CityDaoImpl implements CityDao {

    private final NamedParameterJdbcOperations jdbcOperations;
    private final RowMapper<City> cityRowMapper =
            (rs, rowNum) -> new City(rs.getInt("codeCity"),
                    rs.getInt("codeRegion"),
                    rs.getString("ruCityName"),
                    rs.getString("engCityName"),
                    rs.getInt("population"));

    @Override
    public List<City> findAll() {
        final String sql = "SELECT c.codeCity, c.codeRegion, c.ruCityName, c.engCityName, c.population FROM city c";
        return jdbcOperations.query(sql, cityRowMapper);
    }

    @Override
    public Optional<City> getById(int codeCity) {
        String sql = "SELECT c.codeCity, c.codeRegion, c.ruCityName, c.engCityName, c.population FROM city c" +
                "where c.codeCity = :codeCity";
        try {
            return Optional.ofNullable(jdbcOperations.queryForObject(sql, Map.of("codeCity", codeCity), cityRowMapper));
        } catch (Exception ex) {
            return Optional.empty();
        }
    }

    @Override
    public void create(City city) {
        final String sqlQuery = "insert into city (codeCity, codeRegion, ruCityName, engCityName, population) " +
                "values (:codeCity, :codeRegion, :ruCityName, :engCityName, :population)";
        MapSqlParameterSource namedParametrs = new MapSqlParameterSource();
        final Integer codeCity = city.getCodeCity();
        namedParametrs.addValue("codeCity", codeCity, Types.INTEGER);
        namedParametrs.addValue("codeRegion", city.getCodeRegion(), Types.INTEGER);
        namedParametrs.addValue("ruCityName", city.getRuCityName(), Types.VARCHAR);
        namedParametrs.addValue("engCityName", city.getEngCityName(), Types.VARCHAR);
        namedParametrs.addValue("population", city.getPopulation(), Types.INTEGER);
        jdbcOperations.update(sqlQuery, namedParametrs);
    }

    @Override
    public void update(City city) {
        final String sqlQuery = "update city set codeRegion = :codeRegion, ruCityName = :ruCityName, engCityName = :engCityName, population = :population" +
                "where cityCode = :cityCode";
        jdbcOperations.update(sqlQuery, Map.of(
                "codeCity", city.getCodeCity(),
                "codeRegion", city.getCodeRegion(),
                "ruCityName", city.getRuCityName(),
                "engCityName", city.getEngCityName(),
                "population", city.getPopulation()));
    }

    @Override
    public void deleteById(int codeCity) {
        String sqlQuery = "delete from city c where c.codeCity = :codeCity";
        jdbcOperations.update(sqlQuery, Map.of("codeCity", codeCity));
    }
}
