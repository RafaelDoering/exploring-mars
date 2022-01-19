package com.rafaeldoering.exploringmars.domain.model;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.Test;

public class DirectionTest {
  @Test
  public void givenValidDataWhenInstantiateDirectionThenReturnDirection() throws Exception {
    Direction direction = new Direction(CardinalDirection.NORTH);

    assertNotNull(direction);
  }

  @Test
  public void givenNorthDirectionWhenTurnRightThenChangeDirectionToEast() throws Exception {    
    Direction direction = new Direction(CardinalDirection.NORTH);
    direction.turnRight();

    assertSame(CardinalDirection.EAST, direction.getDirection());
  }

  @Test
  public void givenNorthDirectionWhenTurnLeftThenChangeDirectionToWest() throws Exception {    
    Direction direction = new Direction(CardinalDirection.NORTH);
    direction.turnLeft();

    assertSame(CardinalDirection.WEST, direction.getDirection());
  }
}
