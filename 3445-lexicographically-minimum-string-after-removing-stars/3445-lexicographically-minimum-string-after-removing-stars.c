#include <stdlib.h>
#include <string.h>
typedef struct vec {
#ifndef VEC_DATA_TYPE
#define VEC_DATA_TYPE int
#endif
  int cap;
  int len;
  VEC_DATA_TYPE *data;
} vec;

vec *vec_init(void) {
  vec *ins = (vec *)malloc(sizeof(vec));
  *ins = (vec){4, 0, (VEC_DATA_TYPE *)calloc(4, sizeof(VEC_DATA_TYPE))};
  return ins;
}

void vec_free(vec *pvec) {
  free(pvec->data);
  free(pvec);
}

void vec_append(vec *pvec, VEC_DATA_TYPE n) {
  pvec->data[pvec->len++] = n;
  if (pvec->len == pvec->cap) {
    pvec->cap *= 2;
    pvec->data = realloc(pvec->data, pvec->cap * sizeof(VEC_DATA_TYPE));
  }
}

VEC_DATA_TYPE vec_pop(vec *pvec) {
  pvec->len--;
  return pvec->data[pvec->len];
}

int vec_length(vec *pvec) { return pvec->len; }

char *clearStars(char *s) {
  int N = strlen(s);
  vec *vecs['z' + 1];
  for (int i = 'a'; i < 'z' + 1; i++)
    vecs[i] = vec_init();
  char minChar = 'z';

  for (int i = 0; i < N; i++) {
    if (s[i] == '*') {
      s[i] = 0;
      s[vec_pop(vecs[minChar])] = 0;
      while (minChar < 'z' && vec_length(vecs[minChar]) == 0)
        minChar++;
    } else {
      vec_append(vecs[s[i]], i);
      if (s[i] < minChar)
        minChar = s[i];
    }
  }
  for (int i = 'a'; i < 'z' + 1; i++)
    vec_free(vecs[i]);

  char *rs = malloc((N + 1) * sizeof(char));
  int rsLen = 0;
  for (int i = 0; i < N; i++)
    if (s[i])
      rs[rsLen++] = s[i];
  rs[rsLen] = 0;
  return rs;
}