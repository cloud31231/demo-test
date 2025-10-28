package academy.tochkavhoda.introduction;

public class ZeroSteps4
{
    private ZeroSteps3 helper = new ZeroSteps3();

    /**
     * Находит минимальный элемент в матрице
     */
    public int min(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;
        for (int[] row : matrix) {
            if (row != null) {
                int rowMin = helper.min(row);
                if (rowMin < min) min = rowMin;
            }
        }
        return min;
    }

    /**
     * Находит максимальный элемент в матрице
     */
    public int max(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return Integer.MIN_VALUE;
        int max = Integer.MIN_VALUE;
        for (int[] row : matrix) {
            if (row != null) {
                int rowMax = helper.max(row);
                if (rowMax > max) max = rowMax;
            }
        }
        return max;
    }

    /**
     * Ищет элемент в матрице
     */
    public boolean find(int[][] matrix, int value) {
        if (matrix == null) return false;
        for (int[] row : matrix) {
            if (row != null && helper.find(row, value)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Проверяет, упорядочены ли все строки по убыванию
     */
    public boolean isSortedDescendant(int[][] matrix) {
        if (matrix == null) return true;
        for (int[] row : matrix) {
            if (row != null && !helper.isSortedDescendant(row)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Подсчитывает количество строк без нулей
     */
    public int hasNoZeroRows(int[][] matrix) {
        if (matrix == null) return 0;
        int count = 0;
        for (int[] row : matrix) {
            if (row != null && !helper.find(row, 0)) {
                count++;
            }
        }
        return count;
    }

    /**
     * Проверяет, есть ли строка, состоящая только из нулей
     */
    public boolean hasFullZeroRow(int[][] matrix) {
        if (matrix == null) return false;
        for (int[] row : matrix) {
            if (row != null) {
                boolean allZeros = true;
                for (int value : row) {
                    if (value != 0) {
                        allZeros = false;
                        break;
                    }
                }
                if (allZeros && row.length > 0) return true;
            }
        }
        return false;
    }

    /**
     * Проверяет симметричность матрицы относительно главной диагонали
     */
    public boolean isSymmetric(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return true;

        // Проверяем, что все строки существуют и имеют нужную длину
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i] == null || matrix[i].length != matrix.length) {
                return false;
            }
        }

        // Проверяем симметричность
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < i; j++) {
                if (matrix[i][j] != matrix[j][i]) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Находит максимальный элемент на главной диагонали
     */
    public int mainDiagonalMax(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return Integer.MIN_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i] != null && i < matrix[i].length) {
                if (matrix[i][i] > max) {
                    max = matrix[i][i];
                }
            }
        }
        return max;
    }

    /**
     * Находит сумму положительных элементов на главной диагонали
     */
    public int mainDiagonalPositivesSum(int[][] matrix) {
        if (matrix == null) return 0;
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i] != null && i < matrix[i].length && matrix[i][i] > 0) {
                sum += matrix[i][i];
            }
        }
        return sum;
    }

    /**
     * Находит максимальный элемент на побочной диагонали
     */
    public int secondaryDiagonalMax(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return Integer.MIN_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i] != null && (matrix.length - 1 - i) < matrix[i].length) {
                if (matrix[i][matrix.length - 1 - i] > max) {
                    max = matrix[i][matrix.length - 1 - i];
                }
            }
        }
        return max;
    }

    /**
     * Находит сумму положительных элементов на побочной диагонали
     */
    public int secondaryDiagonalPositivesSum(int[][] matrix) {
        if (matrix == null) return 0;
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i] != null && (matrix.length - 1 - i) < matrix[i].length) {
                int value = matrix[i][matrix.length - 1 - i];
                if (value > 0) sum += value;
            }
        }
        return sum;
    }

    /**
     * Складывает две матрицы
     */
    public int[][] matrixSum(int[][] matrix1, int[][] matrix2) {
        if (matrix1 == null || matrix2 == null || matrix1.length != matrix2.length) {
            return new int[0][];
        }

        int rows = matrix1.length;
        int[][] result = new int[rows][];
        for (int i = 0; i < rows; i++) {
            int[] row1 = matrix1[i];
            int[] row2 = matrix2[i];
            int len1 = row1 == null ? 0 : row1.length;
            int len2 = row2 == null ? 0 : row2.length;
            int maxLen = Math.max(len1, len2);
            result[i] = new int[maxLen];
            for (int j = 0; j < maxLen; j++) {
                int a = j < len1 ? (row1 == null ? 0 : row1[j]) : 0;
                int b = j < len2 ? (row2 == null ? 0 : row2[j]) : 0;
                result[i][j] = a + b;
            }
        }
        return result;
    }

    /**
     * Транспонирует квадратную матрицу
     */
    public void transpose(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix.length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    /**
     * Меняет местами четные и нечетные строки
     */
    public void interchange(int[][] matrix) {
        if (matrix == null || matrix.length < 2) return;

        for (int i = 0; i < matrix.length - 1; i += 2) {
            int[] temp = matrix[i];
            matrix[i] = matrix[i + 1];
            matrix[i + 1] = temp;
        }
    }

    /**
     * Преобразует матрицу в одномерный массив (по строкам)
     */
    public int[] toLinearByRow(int[][] matrix) {
        if (matrix == null) return new int[0];

        // Считаем общую длину
        int totalLength = 0;
        for (int[] row : matrix) {
            if (row != null) totalLength += row.length;
        }

        // Создаем результат
        int[] result = new int[totalLength];
        int pos = 0;

        // Заполняем результат
        for (int[] row : matrix) {
            if (row != null) {
                System.arraycopy(row, 0, result, pos, row.length);
                pos += row.length;
            }
        }

        return result;
    }

    /**
     * Преобразует матрицу в одномерный массив (по столбцам)
     */
    public int[] toLinearByColumn(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return new int[0];

        int size = matrix.length * matrix.length;
        int[] result = new int[size];
        int pos = 0;

        for (int j = 0; j < matrix.length; j++) {
            for (int i = 0; i < matrix.length; i++) {
                result[pos++] = matrix[i][j];
            }
        }

        return result;
    }

    /**
     * Преобразует верхний треугольник матрицы в одномерный массив
     */
    public int[] toLinearByRowUpperTriangle(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return new int[0];

        int size = (matrix.length * (matrix.length + 1)) / 2;
        int[] result = new int[size];
        int pos = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix.length; j++) {
                result[pos++] = matrix[i][j];
            }
        }

        return result;
    }

    /**
     * Суммирует элементы в каждой строке до барьера
     */
    public int sumUntilNotFoundInRow(int[][] matrix, int barrier) {
        if (matrix == null) return 0;

        int sum = 0;
        for (int[] row : matrix) {
            if (row != null) {
                for (int value : row) {
                    if (value == barrier) break;
                    sum += value;
                }
            }
        }
        return sum;
    }

    /**
     * Суммирует все элементы до барьера
     */
    public int sumUntilNotFound(int[][] matrix, int barrier) {
        if (matrix == null) return 0;

        int sum = 0;
        outer: for (int[] row : matrix) {
            if (row != null) {
                for (int value : row) {
                    if (value == barrier) break outer;
                    sum += value;
                }
            }
        }
        return sum;
    }
}
