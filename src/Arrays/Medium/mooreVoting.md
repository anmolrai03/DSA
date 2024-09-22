# Moore's Voting Algorithm

## Process

- Step 1:
  - take el and count = 0;
  - for each element in the array, if count == 0;
    el = ar[i];
  - if count != 0 and ar[i] == el;
    count = count + 1;

  - else count = count - 1;

- Step 2:
  - check if el found appears n/2 times.
  - return the boolean for above answer
