import Data.List.Split

main :: IO()
main = do
  contents <- getContents
  let n = read ((splitOn " " contents) !! 0) :: Int
  let p = read ((splitOn " " contents) !! 1) :: Int
  let q = read ((splitOn " " contents) !! 2) :: Int
  --True is Paul, False is opponent
  if (div (p+q) n) `mod` 2 == 0
    then putStrLn ("paul")
    else putStrLn ("opponent")
