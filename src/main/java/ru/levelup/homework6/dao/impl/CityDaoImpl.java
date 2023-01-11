package ru.levelup.homework6.dao.impl;

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
public class CityDaoImpl implements CityDao {

    private final NamedParameterJdbcOperations jdbcOperations;
    private final RowMapper<City> cityRowMapper;

    public CityDaoImpl(NamedParameterJdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
        this.cityRowMapper = (rs, row) -> {
            final City city = new City();
            city.setId(rs.wasNull() ? null : rs.getInt("id"));
            city.setRuCityName(rs.getString("ru_city_name"));
            city.setEngCityName(rs.getString("eng_city_name"));
            city.setPopulation(rs.getInt("population"));
            city.setRegionId(rs.getInt("region_id"));
            return city;
        };
    }

    @Override
    public List<City> findAll() {
        final String sql = "SELECT * FROM city c";
        return jdbcOperations.query(sql, cityRowMapper);
    }

    @Override
    public Optional<City> getById(int cityId) {
        //language=SQL
        String sql = "SELECT * FROM city c " +
                "where c.id = :cityId";
        try {
            return Optional.ofNullable(jdbcOperations.queryForObject(sql, Map.of("cityId", cityId), cityRowMapper));
        } catch (Exception ex) {
            return Optional.empty();
        }
    }

    @Override
    public void create(City city) {
        final String sqlQuery = "insert into city (id,  ru_city_name, eng_city_name, population, region_id) " +
                "values (:id, :ruCityName, :engCityName, :population, :regionId)";
        MapSqlParameterSource namedParametrs = new MapSqlParameterSource();

        final Integer id = city.getId();
        namedParametrs.addValue("id", id, Types.INTEGER);
        namedParametrs.addValue("ruCityName", city.getRuCityName(), Types.VARCHAR);
        namedParametrs.addValue("engCityName", city.getEngCityName(), Types.VARCHAR);
        namedParametrs.addValue("population", city.getPopulation(), Types.INTEGER);
        namedParametrs.addValue("regionId", city.getRegionId(), Types.INTEGER);
        jdbcOperations.update(sqlQuery, namedParametrs);
    }

    @Override
    public void update(City city) {
        final String sqlQuery = "update city set ru_city_name = :ruCityName, eng_city_name = :engCityName, population = :population, region_id = :regionId" +
                "where id = :cityId";
        jdbcOperations.update(sqlQuery, Map.of(
                "CityId", city.getId(),
                "ruCityName", city.getRuCityName(),
                "engCityName", city.getEngCityName(),
                "population", city.getPopulation(),
                "regionId", city.getRegionId()));
    }

    @Override
    public void deleteById(int cityId) {
        String sqlQuery = "delete from city c where c.id = :cityId";
        jdbcOperations.update(sqlQuery, Map.of("cityId", cityId));
    }
}
