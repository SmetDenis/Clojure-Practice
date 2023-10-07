
.PHONY: src

codestyle:
	cljfmt fix ./src

lint:
	@clj-kondo --lint src

tests:
	@make codestyle
	@make lint
