import Data.List.Split

main :: IO()
main = do
  contents <- getContents
  let eachNumber = splitOn " " contents
  let e = read (eachNumber !! 0) :: Int
  let f = read (eachNumber !! 1) :: Int
  let c = read (eachNumber !! 2) :: Int
  putStrLn (show (howManyDidTimDrink (e + f) c))

howManyDidTimDrink :: Int -> Int -> Int
howManyDidTimDrink total cost
  | total < cost = 0
  | otherwise = 1 + howManyDidTimDrink ((total + 1) - cost) cost
