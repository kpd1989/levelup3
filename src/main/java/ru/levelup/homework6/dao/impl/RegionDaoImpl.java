package ru.levelup.homework6.dao.impl;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import ru.levelup.homework6.dao.CityDao;
import ru.levelup.homework6.dao.RegionDao;
import ru.levelup.homework6.model.City;
import ru.levelup.homework6.model.Region;

import java.sql.Types;
import java.util.List;
import java.util.Map;

@Repository
public class RegionDaoImpl implements RegionDao {
    private final NamedParameterJdbcOperations jdbcOperations;
    private final RowMapper<Region> regionRowMapper;

    public RegionDaoImpl(NamedParameterJdbcOperations jdbcOperations, CityDao cityDao) {
        this.jdbcOperations = jdbcOperations;
        this.regionRowMapper = (rs, row) -> {
            final Region region = new Region();
            region.setId(rs.getInt("id"));
            region.setRegName(rs.getString("regName"));
            City city = cityDao.getById(rs.getInt("codeCity")).orElse(null);
            region.setCity(city);
            return region;
        };
    }

    @Override
    public List<Region> findAll() {
        final String sql = "SELECT * FROM region";
        return jdbcOperations.query(sql, regionRowMapper);
    }

    @Override
    public int create(Region region) {
        final String sqlQuery = "insert into region (id, regName, codeCity) " +
                "values (:id, :regName, :codeCity)";
        MapSqlParameterSource namedParametrs = new MapSqlParameterSource();
        final Integer id = region.getId();
        namedParametrs.addValue("id", id, Types.INTEGER);
        namedParametrs.addValue("regName", region.getRegName(), Types.VARCHAR);
        namedParametrs.addValue("codeCity", region.getCodeCity(), Types.INTEGER);
        jdbcOperations.update(sqlQuery, namedParametrs);
        return id;
    }

    @Override
    public void update(Region region) {
        final String sqlQuery = "update city set regName = :regName, codeCity = :codeCity" +
                "where id = :id";
        jdbcOperations.update(sqlQuery, Map.of(
                "id", region.getCodeCity(),
                "regName", region.getRegName(),
                "codeCity", region.getCodeCity()));
    }

}
